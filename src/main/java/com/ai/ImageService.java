package com.ai;

import org.springframework.ai.image.ImagePrompt;
import org.springframework.ai.image.ImageResponse;
import org.springframework.ai.openai.OpenAiImageModel;
import org.springframework.ai.openai.OpenAiImageOptions;
import org.springframework.stereotype.Service;

@Service
public class ImageService {

	OpenAiImageModel openAiImageModel;

	public ImageService(OpenAiImageModel openAiImageModel) {
		super();
		this.openAiImageModel = openAiImageModel;
	}
	
	public ImageResponse generateImage(String prompt) {
		
//		ImageResponse imageResponse = openAiImageModel.call(
//				new ImagePrompt(prompt));
						
		ImageResponse imageResponse = openAiImageModel.call(
				new ImagePrompt(prompt,
					OpenAiImageOptions.builder()
					.withQuality("hd")
					.withN(1) // number of images we request
					.withHeight(1024)
					.withWidth(1024)
					.build())
				);
		
		return imageResponse;
	}
	
}
