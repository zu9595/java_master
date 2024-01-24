package com.serv;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lambda {
	public static void main(String[] args) {
		
		List<ReviewVO> review = new ArrayList<>();
		review.add(new ReviewVO("리뷰2","기자"));
		review.add(new ReviewVO("리뷰1","길동"));
		review.add(new ReviewVO("리뷰3","순신"));
		
		review.sort(new ReviewCompare());
		System.out.println(review);
	}
}

class ReviewCompare implements Comparator<ReviewVO>{

	@Override
	public int compare(ReviewVO o1, ReviewVO o2) {
		return o1.getContent().compareTo(o2.getContent());
	}
	
}