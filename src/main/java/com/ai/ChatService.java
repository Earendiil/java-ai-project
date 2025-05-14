package com.ai;

import org.springframework.ai.chat.model.ChatModel;
import org.springframework.ai.chat.model.ChatResponse;
import org.springframework.ai.chat.prompt.Prompt;
import org.springframework.ai.openai.OpenAiChatOptions;
import org.springframework.stereotype.Service;
import org.springframework.ai.chat.messages.AssistantMessage;


@Service
public class ChatService {

    private final ChatModel chatModel;

    public ChatService(ChatModel chatModel) {
        this.chatModel = chatModel;
    }

    public String getResponse(String prompt) {
    	return chatModel.call(prompt);
		
	}
    
    public String getResponseOptions(String prompt) {
        ChatResponse response = chatModel.call(
        		new Prompt(
        				prompt,
        				OpenAiChatOptions.builder()
                        .model("gpt-4")
                        .temperature((double) 0.4f)
                        .build()
        				));
        		
        AssistantMessage message = (AssistantMessage) response.getResult().getOutput();
        return message.getText(); //  This works in M8 version

    }
}
