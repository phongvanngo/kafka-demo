package novapo.kafka.producer.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import novapo.kafka.producer.service.ProducerService;
import novapo.kafka.producer.service.dto.SendMessageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/producer")
@RequiredArgsConstructor
public class ProducerController {

    @Autowired
    private ProducerService producerService;

    @PostMapping("/send")
    public String sendMessage(@RequestBody SendMessageDTO message) throws JsonProcessingException {
        return producerService.sendMessage(message);
    }
}
