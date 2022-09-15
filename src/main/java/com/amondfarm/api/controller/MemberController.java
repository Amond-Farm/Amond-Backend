package com.amondfarm.api.controller;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.amondfarm.api.dto.ExperienceRequest;
import com.amondfarm.api.dto.ExperienceResponse;
import com.amondfarm.api.dto.MissionCompleteResponse;
import com.amondfarm.api.dto.MissionRequest;
import com.amondfarm.api.dto.MissionResponse;
import com.amondfarm.api.dto.SignUpRequest;
import com.amondfarm.api.dto.SignUpResponse;
import com.amondfarm.api.dto.WithdrawRequest;
import com.amondfarm.api.dto.WithdrawResponse;
import com.amondfarm.api.domain.enums.ProviderType;
import com.amondfarm.api.service.MemberService;

import lombok.RequiredArgsConstructor;

/**
 * Member Controller
 *
 * @since 2022-08-29
 * @author jwlee
 */


@RestController
@RequiredArgsConstructor
public class MemberController {

	private final MemberService memberService;

	@PostMapping("/v1/signup")
	public ResponseEntity<SignUpResponse> join(@RequestBody @Valid SignUpRequest request) {
		SignUpResponse response = memberService.join(request);
		return ResponseEntity.ok(response);
	}

	@DeleteMapping("/v1/withdraw")
	public ResponseEntity<WithdrawResponse> withdraw(@RequestBody @Valid WithdrawRequest request) {
		WithdrawResponse response = memberService.withdraw(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/v1/exp")
	public ResponseEntity<ExperienceResponse> getExperience(
		@RequestParam(value = "provider") ProviderType providerType,
		@RequestParam(value = "uid") String uid) {

		ExperienceResponse response = memberService.getExperience(providerType, uid);
		return ResponseEntity.ok(response);
	}

	@PutMapping("/v1/exp")
	public ResponseEntity<ExperienceResponse> updateExperience(@RequestBody ExperienceRequest request) {
		ExperienceResponse response = memberService.updateExperience(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/v1/mission")
	public ResponseEntity<MissionResponse> getMission(
		@RequestParam(value = "provider") ProviderType providerType,
		@RequestParam(value = "uid") String uid) {

		MissionResponse response = memberService.getMemberMission(providerType, uid);

		return ResponseEntity.ok(response);
	}

	@PutMapping("/v1/mission")
	public ResponseEntity<MissionCompleteResponse> updateMission(@RequestBody MissionRequest request) {
		MissionCompleteResponse response = memberService.completeMission(request);
		return ResponseEntity.ok(response);
	}
}