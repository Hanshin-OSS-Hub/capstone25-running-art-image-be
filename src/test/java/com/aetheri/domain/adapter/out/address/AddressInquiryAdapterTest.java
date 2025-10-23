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
                .expectNextCount(1) // 1개의 데이터가 올 것을 기대
                .verifyComplete();  // 스트림이 성공적으로 완료되는지 검증 (이때까지 테스트가 대기함)
    }

    @Test
    public void failure_when_executor_fails() {
        // given
        // (만약 WebClient를 Mocking해서 강제로 오류를 발생시킬 수 있다면...)
        String address = "error_trigger_keyword";

        // when
        var mono = addressInquiryAdapter.inquiryAddress(address);

        // then
        StepVerifier.create(mono)
                .expectError(BusinessException.class) // BusinessException이 발생하는지 검증
                .verify(); // 오류가 발생하고 스트림이 종료되는지 검증
    }
}