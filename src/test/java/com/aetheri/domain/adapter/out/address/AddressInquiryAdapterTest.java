package com.aetheri.domain.adapter.out.address;

import com.aetheri.domain.exception.BusinessException;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import reactor.test.StepVerifier;

@SpringBootTest
@ActiveProfiles("test") // <-- 이 부분을 추가
class AddressInquiryAdapterTest {

    @Autowired
    private AddressInquiryAdapter addressInquiryAdapter;

    @Test
    public void success_inquiry_address() {
        // given
        String address = "한신대학교";

        // when
        var mono = addressInquiryAdapter.inquiryAddress(address);
        mono.subscribe(System.out::println);

        // then
        StepVerifier.create(mono)
                .expectNextMatches(response -> {
                    // API 응답 구조 검증
                    return response != null && response.results() != null;
                })
                .verifyComplete();  // 스트림이 성공적으로 완료되는지 검증 (이때까지 테스트가 대기함)
    }

    @Test
    public void failure_when_executor_fails() {
        // given
        String address = "존재하지않는주소123456";

        // when
        var mono = addressInquiryAdapter.inquiryAddress(address);

        // then
        StepVerifier.create(mono)
                .expectNextMatches(response -> response.results().juso().isEmpty())
                .verifyComplete();
    }
}