package com.example.myController;

import java.util.*;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bfhl")
public class BfhlController {

    @GetMapping
    public Map<String, Integer> getOperationCode() {
        Map<String, Integer> response = new LinkedHashMap<>();
        response.put("operation_code", 1);
        return response;
    }

    @PostMapping
    public Map<String, Object> processInput(@RequestBody Map<String, List<String>> payload) {
        Map<String, Object> response = new LinkedHashMap<>();
        
        // Update with actual details
        String userId = "Shreya_Gupta_11";
        String email = "shreya.gupta2021a@vitstudent.ac.in";
        String rollNumber = "21BCB0142";

        List<String> data = payload.get("data");
        List<String> numbers = new ArrayList<>();
        List<String> alphabets = new ArrayList<>();
        String highestLowercase = "";

        for (String item : data) {
            if (item.matches("\\d+")) {
                numbers.add(item);
            } else if (item.matches("[a-zA-Z]")) {
                alphabets.add(item);
                if (item.matches("[a-z]") && item.compareTo(highestLowercase) > 0) {
                    highestLowercase = item;
                }
            }
        }

        // Ensure the order of the keys in the response
        response.put("is_success", true);
        response.put("user_id", userId);
        response.put("email", email);
        response.put("roll_number", rollNumber);
        response.put("numbers", numbers);
        response.put("alphabets", alphabets);
        response.put("highest_lowercase_alphabet", highestLowercase.isEmpty() ? Collections.emptyList() : Collections.singletonList(highestLowercase));

        return response;
    }
}
