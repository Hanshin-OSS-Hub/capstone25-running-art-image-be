package com.aetheri.application.dto.image;

import com.aetheri.domain.enums.image.Proficiency;
import com.aetheri.domain.enums.image.Shape;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;

import java.time.LocalDate;

@Builder
@Schema(description = "이미지 메타데이터 및 접근 경로를 포함하는 최종 응답 DTO")
public record ImageMetadataResponse(
        @Schema(
                description = "이미지의 현재 제목",
                example = "나의 런닝 아트"
        )
        String title,

        @Schema(
                description = "이미지에 대한 상세 설명",
                example = "2025년 10월 15일에 생성된 5km 달리기 경로 이미지입니다."
        )
        String description,

        @Schema(
                description = "이미지가 생성된 위치",
                example = "한신대학교"
        )
        String location,

        @Schema(
                description = "클라이언트가 접근 가능한 최종 이미지 URL 또는 경로",
                example = "/api/v1/image/{이미지 아이디}"
        )
        String imagePath,

        @Schema(
                description = "이미지의 주된 형태 또는 스타일",
                example = "SQUARE",             // Shape Enum의 가능한 값 중 하나
                implementation = Shape.class
        )
        Shape shape,

        @Schema(
                description = "이미지 생성 시 사용된 사용자의 숙련도 수준",
                example = "INTERMEDIATE",       // Proficiency Enum의 가능한 값 중 하나
                implementation = Proficiency.class
        )
        Proficiency proficiency,

        @Schema(
                description = "해당 이미지가 다른 사용자에게 공개(공유)되었는지 여부",
                example = "true"
        )
        Boolean shared,

        @Schema(
                description = "메타데이터가 최초로 생성된 날짜 (YYYY-MM-DD)",
                example = "2024-05-15"
        )
        LocalDate createdAt,

        @Schema(
                description = "메타데이터가 마지막으로 수정된 날짜 (YYYY-MM-DD)",
                example = "2024-05-16"
        )
        LocalDate modifiedAt
) {
}