package com.aetheri.application.result.me;

import com.aetheri.infrastructure.persistence.entity.Runner;

public record MeResult(String name) {
    // TODO Domain 엔티티를 직접 참조하고 있는데, 이는 레이어 규칙을 위반한 것임
    public static MeResult of(Runner runner) {
        return new MeResult(runner.getName());
    }
}