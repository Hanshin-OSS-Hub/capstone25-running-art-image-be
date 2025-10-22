package com.aetheri.application.dto.image;

import com.aetheri.domain.enums.image.Proficiency;
import com.aetheri.domain.enums.image.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;

public record ImageMetadataSaveRequest(
        @NotNull
        @Schema(
                description = "런닝 아트가 생성된 위치",
                example = "한신대학교",
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        String location,

        @NotNull
        @Schema(
                description = "이미지 생성에 사용된 사용자의 숙련도 수준",
                example = "BEGINNER",                   // 해당 Enum의 가능한 값 중 하나를 예시로 둡니다.
                implementation = Proficiency.class,     // 가능한 값의 목록을 명시적으로 표시합니다.
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        Proficiency proficiency,

        @NotNull
        @Schema(
                description = "이미지의 주된 형태 또는 스타일",
                example = "SQUARE",                 // 해당 Enum의 가능한 값 중 하나를 예시로 둡니다.
                implementation = Shape.class,       // 가능한 값의 목록을 명시적으로 표시합니다.
                requiredMode = RequiredMode.NOT_REQUIRED
        )
        Shape shape
) {
}