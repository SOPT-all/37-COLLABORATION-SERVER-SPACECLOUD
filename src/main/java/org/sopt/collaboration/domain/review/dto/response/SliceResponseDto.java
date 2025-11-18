package org.sopt.collaboration.domain.review.dto.response;

import org.springframework.data.domain.Slice;

import java.util.List;

public record SliceResponseDto<T>(
        List<T> content,
        boolean hasNext
) {
    public static <T> SliceResponseDto<T> fromSlice(Slice<T> slice) {
        return new SliceResponseDto<>(
                slice.getContent(),
                slice.hasNext()
        );
    }
}
