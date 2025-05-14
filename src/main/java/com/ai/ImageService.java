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
	
	public ImageResponse generateImage(String prompt, String quality, int n, int width, int height) {
		
		
		
//		ImageResponse imageResponse = openAiImageModel.call(
//				new ImagePrompt(prompt));
						
//		ImageResponse imageResponse = openAiImageModel.call(
//				new ImagePrompt(prompt,
//					OpenAiImageOptions.builder()
//					.withModel("dall-e-3")
//					.withQuality("hd")
//					.withN(1) // number of images we request
//					.withHeight(1024)
//					.withWidth(1024)
//					.build())
//				);
		
		ImageResponse imageResponse = openAiImageModel.call(
				new ImagePrompt(prompt,
					OpenAiImageOptions.builder()
					.withModel("dall-e-3")
					.withQuality(quality)
					.withN(n) // this model so far supports only 1 per request
					.withHeight(height)
					.withWidth(width)
					.build())
				);
		return imageResponse;
	}
	
}
