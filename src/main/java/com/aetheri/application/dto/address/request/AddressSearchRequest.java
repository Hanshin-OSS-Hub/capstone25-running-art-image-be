package com.aetheri.application.dto.address.request;

/**
 * 도로명 주소 검색 요청 DTO (record)
 * (필수 파라미터인 confmKey, currentPage, countPerPage, keyword만 포함)
 */
public record AddressSearchRequest(
    String confmKey,     // 필수: 승인키
    int currentPage,   // 필수: 현재 페이지
    int countPerPage,  // 필수: 페이지당 건수
    String keyword       // 필수: 검색어
    
    // (필요에 따라 resultType, addInfoYn 등 다른 파라미터도 추가 가능)
) {
}