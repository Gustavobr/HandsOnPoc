package br.com.poc.rabbitmq;

import org.springframework.stereotype.Component;

@Component
//@Configuration
public class MessageProduce {
	/*
		private final RabbitTemplate rabbitTemplate;
		
		
		
		@Autowired
		
		public MessageProduce(RabbitTemplate rabbitTemplate) {
			this.rabbitTemplate = rabbitTemplate;
		}
		
		//@Bean
		public String sendMessage(String queueName, String message) {
			rabbitTemplate.convertAndSend(queueName, message);
			
			return message;
		}
	*/
}
