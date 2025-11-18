package org.sopt.collaboration.domain.place.entity;

import java.util.ArrayList;
import java.util.List;

import org.sopt.collaboration.domain.common.BaseEntity;
import org.sopt.collaboration.domain.place.entity.enums.filter.FilterCategory;
import org.sopt.collaboration.domain.place.entity.enums.place.PriceUnit;
import org.sopt.collaboration.domain.place.entity.enums.place.PurchaseType;
import org.sopt.collaboration.domain.place.entity.enums.place.Location;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "place")
public class Place extends BaseEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false)
	private String name;

	@Column(name = "capacity", nullable = false)
	private int capacity;

	@Column(name = "comment_count", nullable = false)
	private int commentCount;

	@Column(name = "like_count", nullable = false)
	private int likeCount;

	@Column(name = "price", nullable = false)
	private int price;

	@Column(name = "price_unit", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private PriceUnit priceUnit;

	@Column(name = "address", nullable = false)
	private String address;

	@Column(name = "location", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private Location location;

	@Column(name = "thumb_nail_image_url", nullable = false)
	private String thumbnailImageUrl;

	@Column(name = "purchase_type", nullable = false)
	@Enumerated(value = EnumType.STRING)
	private PurchaseType purchaseType;

	@Column(name = "coupon", nullable = false)
	private boolean coupon;

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
    private List<PlaceFilter> placeFilters = new ArrayList<>();

    @OneToMany(mappedBy = "place", fetch = FetchType.LAZY)
	private List<PlaceHashtag> placeHashtags = new ArrayList<>();
}
