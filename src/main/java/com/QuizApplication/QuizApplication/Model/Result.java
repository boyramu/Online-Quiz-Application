package com.QuizApplication.QuizApplication.Model;

import java.time.LocalDateTime;

public class Result {
    private Long id;
    private Long userId;
    private String username;
    private Long quizId;
    private String quizTitle;
    private int score;
    private int noOfAttempts;
    private LocalDateTime attemptedDateTime;

    public Result() {
    }

    public Result(Long id, Long userId, String username, Long quizId, String quizTitle, int score, int noOfAttempts, LocalDateTime attemptedDateTime) {
        this.id = id;
        this.userId = userId;
        this.username = username;
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.score = score;
        this.noOfAttempts = noOfAttempts;
        this.attemptedDateTime = attemptedDateTime;
    }

    public Result(Long userId, String username, Long quizId, String quizTitle, int score, int noOfAttempts, LocalDateTime attemptedDateTime) {
        this.userId = userId;
        this.username = username;
        this.quizId = quizId;
        this.quizTitle = quizTitle;
        this.score = score;
        this.noOfAttempts = noOfAttempts;
        this.attemptedDateTime = attemptedDateTime;
    }

    
	
	// Getters and setters for all fields

    public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public Long getQuizId() {
		return quizId;
	}

	public void setQuizId(Long quizId) {
		this.quizId = quizId;
	}

	public String getQuizTitle() {
		return quizTitle;
	}

	public void setQuizTitle(String quizTitle) {
		this.quizTitle = quizTitle;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public int getNoOfAttempts() {
		return noOfAttempts;
	}

	public void setNoOfAttempts(int noOfAttempts) {
		this.noOfAttempts = noOfAttempts;
	}

	public LocalDateTime getAttemptedDateTime() {
        return attemptedDateTime;
    }

    public void setAttemptedDateTime(LocalDateTime attemptedDateTime) {
        this.attemptedDateTime = attemptedDateTime;
    }

    // Other getters and setters remain the same...
}
