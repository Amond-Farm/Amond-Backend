package com.amondfarm.api.member.dto;

import com.amondfarm.api.member.enums.ProviderType;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ExperienceRequest {

	private ProviderType provider;
	private String email;
	private int exp;
}