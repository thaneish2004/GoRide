package com.taxi.app.dto;

import java.util.Map;

/**
 * Generic API response wrapper used for AJAX endpoints.
 * Provides a consistent envelope with success flag, message, payload, and optional metadata.
 *
 * @param <T> the type of the data payload
 */
public class ApiResponse<T> {
    /** Whether the request was successful. */
    private boolean success;
    /** Human-readable status message. */
    private String message;
    /** Response payload. */
    private T data;
    /** Optional extra metadata (e.g. pagination info). */
    private Map<String, Object> metadata;

    /** Required by Jackson. */
    public ApiResponse() {}

    /** Creates a response with success flag and message only. */
    public ApiResponse(boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    /** Creates a response with success flag, message, and data payload. */
    public ApiResponse(boolean success, String message, T data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() { return success; }
    public void setSuccess(boolean success) { this.success = success; }
    public String getMessage() { return message; }
    public void setMessage(String message) { this.message = message; }
    public T getData() { return data; }
    public void setData(T data) { this.data = data; }
    public Map<String, Object> getMetadata() { return metadata; }
    public void setMetadata(Map<String, Object> metadata) { this.metadata = metadata; }

    /** Convenience factory for a successful response with data. */
    public static <T> ApiResponse<T> ok(String message, T data) {
        return new ApiResponse<>(true, message, data);
    }

    /** Convenience factory for a failed response. */
    public static <T> ApiResponse<T> fail(String message) {
        return new ApiResponse<>(false, message);
    }
}
