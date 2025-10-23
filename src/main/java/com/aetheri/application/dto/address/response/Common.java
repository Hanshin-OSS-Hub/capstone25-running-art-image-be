package com.aetheri.application.dto.address.response;

public record Common(
    String totalCount,
    String currentPage,
    String countPerPage,
    String errorCode,
    String errorMessage
) {}