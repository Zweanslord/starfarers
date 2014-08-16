package com.starfarers.validation.validator;

import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.starfarers.validation.UniquePlayerView;
import com.starfarers.view.PlayerView;

public class UniquePlayerViewValidator implements ConstraintValidator<UniquePlayerView, List<PlayerView>> {

	public void initialize(UniquePlayerView constraintAnnotation) {
	}

	public boolean isValid(List<PlayerView> playerViews, ConstraintValidatorContext constraintContext) {
		for (PlayerView playerView : playerViews) {
			for (PlayerView toCompareWith : playerViews) {
				if (isNotUnique(playerView, toCompareWith)) {
					return false;
				}
			}
		}
		return true;
	}

	private boolean isNotUnique(PlayerView playerView, PlayerView otherPlayerView) {
		return playerView != otherPlayerView && !playerView.isDelete() && !otherPlayerView.isDelete() && playerView.getName().equals(otherPlayerView.getName());
	}

}
