package com.modtion.fightcovid.response;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import static com.modtion.fightcovid.response.StatusResponse.EMPTY;
import static com.modtion.fightcovid.response.StatusResponse.ERROR;
import static com.modtion.fightcovid.response.StatusResponse.LOADING;
import static com.modtion.fightcovid.response.StatusResponse.SUCCESS;


public class ApiResponse<T> {

    @NonNull
    public final StatusResponse status;

    @Nullable
    public final String message;

    @Nullable
    public final T body;

    private ApiResponse(@NonNull StatusResponse status, @Nullable T body, @Nullable String message) {
        this.status = status;
        this.body = body;
        this.message = message;
    }

    public static <T> ApiResponse<T> success(@Nullable T body) {
        return new ApiResponse<>(SUCCESS, body, null);
    }

    public static <T> ApiResponse<T> empty(String msg) {
        return new ApiResponse<>(EMPTY, null, msg);
    }

    public static <T> ApiResponse<T> error(String msg) {
        return new ApiResponse<>(ERROR, null, msg);
    }

    public static <T> ApiResponse<T> loading(@Nullable T body) {
        return new ApiResponse<>(LOADING, body, null);
    }
}
