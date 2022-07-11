package com.JMThouseWeb.JMThouse.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.JMThouseWeb.JMThouse.model.Reply;
import com.JMThouseWeb.JMThouse.model.Review;
import com.JMThouseWeb.JMThouse.repository.ReplyRepository;
import com.JMThouseWeb.JMThouse.repository.ReviewRepository;

@Service
public class ReviewService {

	@Autowired
	private ReviewRepository reviewRepository;
	
	@Autowired
	private ReplyRepository replyRepository;

	@Transactional
	public void postReview(Review review) {
		reviewRepository.save(review);
	}

	@Transactional
	public Review getReviewDetail(int reviewId) {
		return reviewRepository.findById(reviewId).orElseThrow(() -> {
			return new IllegalArgumentException("해당 리뷰는 존재하지 않습니다.");
		});
	}

	@Transactional(readOnly = true)
	public List<Review> getReviewList(int houseId) {
		List<Review> reviews = reviewRepository.findByHouseId(houseId);
		return reviews;
	}

	@Transactional
	public Reply addReply(int reviewId, Reply requestReply) {
		Review reviewEntity = reviewRepository.findById(reviewId).orElseThrow(() -> {
			return new IllegalArgumentException("해당 리뷰는 존재하지 않습니다.");
		});

		requestReply.setReviewId(reviewEntity);

		Reply replyEntity = replyRepository.save(requestReply);
		return replyEntity;
	}

}
