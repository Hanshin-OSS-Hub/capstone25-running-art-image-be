package com.aetheri.application.service.address;

import com.aetheri.application.port.in.address.AddressVerificationPort;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Slf4j
@Service
public class AddressVerificationService implements AddressVerificationPort {
    @Override
    public Mono<Boolean> verifyAddress(String address) {
        return null;
    }
}