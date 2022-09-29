package com.amondfarm.api.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.amondfarm.api.domain.enums.character.AcquisitionCondition;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Character {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "character_id")
	private Long id;

	@Column(nullable = false)
	private String characterName;

	@Column(nullable = false)
	private String description;

	@Column(nullable = false)
	private String stage1ImageUrl;

	@Column(nullable = false)
	private String stage1Level;

	@Column(name = "stage2_silhouette_image_url", nullable = false)
	private String stage2SilhouetteUrl;

	@Column(nullable = false)
	private String stage2ImageUrl;

	@Column(nullable = false)
	private String stage2Level;

	@Column(name = "stage3_silhouette_image_url", nullable = false)
	private String stage3SilhouetteUrl;

	@Column(nullable = false)
	private String stage3ImageUrl;

	@Column(nullable = false)
	private String stage3Level;

	@Column(name = "stage4_silhouette_image_url", nullable = false)
	private String stage4SilhouetteUrl;

	@Column(nullable = false)
	private String stage4ImageUrl;

	@Column(nullable = false)
	private String stage4Level;

	@Column(nullable = false)
	private int completionStage;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private AcquisitionCondition acquisitionCondition;

	@Builder
	public Character(String characterName, String description, String stage1ImageUrl, String stage1Level,
		String stage2SilhouetteUrl, String stage2ImageUrl, String stage2Level, String stage3SilhouetteUrl,
		String stage3ImageUrl, String stage3Level, String stage4SilhouetteUrl, String stage4ImageUrl,
		String stage4Level,
		int completionStage, AcquisitionCondition acquisitionCondition) {
		this.characterName = characterName;
		this.description = description;
		this.stage1ImageUrl = stage1ImageUrl;
		this.stage1Level = stage1Level;
		this.stage2SilhouetteUrl = stage2SilhouetteUrl;
		this.stage2ImageUrl = stage2ImageUrl;
		this.stage2Level = stage2Level;
		this.stage3SilhouetteUrl = stage3SilhouetteUrl;
		this.stage3ImageUrl = stage3ImageUrl;
		this.stage3Level = stage3Level;
		this.stage4SilhouetteUrl = stage4SilhouetteUrl;
		this.stage4ImageUrl = stage4ImageUrl;
		this.stage4Level = stage4Level;
		this.completionStage = completionStage;
		this.acquisitionCondition = acquisitionCondition;
	}

	//==생성 메소드==//
	// public static Character from(CreateCharacterRequest request) {
	// 	return Character.builder()
	// 		.build();
	// }
}
