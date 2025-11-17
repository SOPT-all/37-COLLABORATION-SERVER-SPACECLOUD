package org.sopt.collaboration.domain.place.dto.response;

import java.util.List;

import org.sopt.collaboration.domain.place.entity.Place;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.springframework.data.domain.Slice;

public record PlaceInfoListDto(
		List<PlaceInfoDto> result,
		boolean hasNext
) {
	public static PlaceInfoListDto from(Slice<Place> places) {
		return new PlaceInfoListDto(
				places.getContent().stream().map(PlaceInfoDto::from).toList(),
				places.hasNext()
		);
	}

	private record PlaceInfoDto(
			long id,
			String name,
			int capacity,
			int likeCount,
			int commentCount,
			int price,
			PriceUnit priceUnit,
			String address,
			String thumbnailImageUrl,
			boolean coupon,
			List<String> hashtags
	) {
		private static PlaceInfoDto from(Place place) {
			return new PlaceInfoDto(
					place.getId(),
					place.getName(),
					place.getCapacity(),
					place.getLikeCount(),
					place.getCommentCount(),
					place.getPrice(),
					place.getPriceUnit(),
					place.getAddress(),
					place.getThumbnailImageUrl(),
					place.isCoupon(),
					place.getPlaceHashtags().stream()
					.map(placeHashtag -> placeHashtag.getHashtag().getName())
					.toList());
		}
	}
}
