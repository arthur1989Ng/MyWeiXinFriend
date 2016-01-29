/*
 * Copyright (C) 2014 Square, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.nian.myweixinfriend.picasso;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;

import java.io.IOException;

/**
 * {@link com.squareup.picasso.RequestHandler} allows you to extend Picasso to load images
 * in ways that are not supported by default in the library.
 * <p>
 * <h2>Usage</h2>
 * <p>{@link com.squareup.picasso.RequestHandler} must be subclassed to be used. You will have to
 * override two methods ({@link #canHandleRequest(com.squareup.picasso.Request)} and
 * {@link #load(com.squareup.picasso.Request)}) with your custom logic to load images.</p>
 *
 * <p>You should then register your {@link com.squareup.picasso.RequestHandler} using
 * {@link com.squareup.picasso.Picasso.Builder#addRequestHandler(com.squareup.picasso.RequestHandler)}</p>
 *
 * <b>NOTE:</b> This is a beta feature. The API is subject to change in a backwards
 * incompatible way at any time.
 *
 * @see com.squareup.picasso.Picasso.Builder#addRequestHandler(com.squareup.picasso.RequestHandler)
 */
public abstract class RequestHandler {
  /**
   * {@link com.squareup.picasso.RequestHandler.Result} represents the result of a {@link #load(com.squareup.picasso.Request)} call in a
   * {@link com.squareup.picasso.RequestHandler}.
   *
   * @see com.squareup.picasso.RequestHandler
   * @see #load(com.squareup.picasso.Request)
   */
  public static final class Result {
    private final Picasso.LoadedFrom loadedFrom;
    private final Bitmap bitmap;
    private final int exifOrientation;

    public Result(Bitmap bitmap, Picasso.LoadedFrom loadedFrom) {
      this(bitmap, loadedFrom, 0);
    }

    Result(Bitmap bitmap, Picasso.LoadedFrom loadedFrom, int exifOrientation) {
      this.bitmap = bitmap;
      this.loadedFrom = loadedFrom;
      this.exifOrientation = exifOrientation;
    }

    /**
     * Returns the resulting {@link Bitmap} generated
     * from a {@link #load(com.squareup.picasso.Request)} call.
     */
    public Bitmap getBitmap() {
      return bitmap;
    }

    /**
     * Returns the resulting {@link com.squareup.picasso.Picasso.LoadedFrom} generated
     * from a {@link #load(com.squareup.picasso.Request)} call.
     */
    public Picasso.LoadedFrom getLoadedFrom() {
      return loadedFrom;
    }

    /**
     * Returns the resulting EXIF orientation generated
     * from a {@link #load(com.squareup.picasso.Request)} call. This is only accessible
     * to built-in RequestHandlers.
     */
    int getExifOrientation() {
      return exifOrientation;
    }
  }

  /**
   * Whether or not this {@link com.squareup.picasso.RequestHandler} can handle a request with the
   * given {@link com.squareup.picasso.Request}.
   */
  public abstract boolean canHandleRequest(Request data);

  /**
   * Loads an image for the given {@link com.squareup.picasso.Request}.
   *
   * @param data the {@link android.net.Uri} to load the image from.
   * @return A {@link com.squareup.picasso.RequestHandler.Result} instance representing the result.
   */
  public abstract Result load(Request data) throws IOException;

  int getRetryCount() {
    return 0;
  }

  boolean shouldRetry(boolean airplaneMode, NetworkInfo info) {
    return false;
  }

  boolean supportsReplay() {
    return false;
  }

  /**
   * Lazily create {@link BitmapFactory.Options} based in given
   * {@link com.squareup.picasso.Request}, only instantiating them if needed.
   */
  static BitmapFactory.Options createBitmapOptions(Request data) {
    final boolean justBounds = data.hasSize();
    final boolean hasConfig = data.config != null;
    BitmapFactory.Options options = null;
    if (justBounds || hasConfig) {
      options = new BitmapFactory.Options();
      options.inJustDecodeBounds = justBounds;
      if (hasConfig) {
        options.inPreferredConfig = data.config;
      }
    }
    return options;
  }

  static boolean requiresInSampleSize(BitmapFactory.Options options) {
    return options != null && options.inJustDecodeBounds;
  }

  static void calculateInSampleSize(int reqWidth, int reqHeight, BitmapFactory.Options options) {
    calculateInSampleSize(reqWidth, reqHeight, options.outWidth, options.outHeight, options);
  }

  static void calculateInSampleSize(int reqWidth, int reqHeight, int width, int height,
                                    BitmapFactory.Options options) {
    int sampleSize = 1;
    if (height > reqHeight || width > reqWidth) {
      final int heightRatio = (int) Math.floor((float) height / (float) reqHeight);
      final int widthRatio = (int) Math.floor((float) width / (float) reqWidth);
      sampleSize = heightRatio < widthRatio ? heightRatio : widthRatio;
    }
    options.inSampleSize = sampleSize;
    options.inJustDecodeBounds = false;
  }
}
