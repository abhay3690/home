package com.demo.service;


public interface CommentService {
	CommentDto createComment(CommentDto commentDto,Integer postId);
	void deleteComment(Integer commentID);
	

}
