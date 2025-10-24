package com.aetheri.application.port.in.redis;

import com.aetheri.application.command.jwt.TokenResult;
import reactor.core.publisher.Mono;

public interface RefreshTokenUseCase {
    Mono<TokenResult> refreshToken(Long runnerId);
    Mono<TokenResult> reissueTokens(String refreshToken);
}