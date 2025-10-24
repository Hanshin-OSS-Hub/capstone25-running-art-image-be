package com.aetheri.infrastructure.adapter.out.address.dto;

public record Common(
    String totalCount,
    String currentPage,
    String countPerPage,
    String errorCode,
    String errorMessage
) {}