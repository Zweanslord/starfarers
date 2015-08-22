package com.starfarers.domain.species;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import com.starfarers.domain.common.Common;
import com.starfarers.domain.user.User;

@Entity
@Table
public class Species extends Common {

	@NotNull
	@Column(nullable = false)
	private String name;

	@Enumerated(EnumType.STRING)
	private TechnologyType technologyType;

	@Enumerated(EnumType.STRING)
	private SubmissionStatus submissionStatus = SubmissionStatus.CREATION;

	@OneToOne
	@JoinColumn(name = "fk_user", nullable = false)
	private User user;

	public boolean isAccepted() {
		return SubmissionStatus.ACCEPTED.equals(submissionStatus);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public TechnologyType getTechnologyType() {
		return technologyType;
	}

	public void setTechnologyType(TechnologyType technologyType) {
		this.technologyType = technologyType;
	}

	public SubmissionStatus getSubmissionStatus() {
		return submissionStatus;
	}

	public void setSubmissionStatus(SubmissionStatus submissionStatus) {
		this.submissionStatus = submissionStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}