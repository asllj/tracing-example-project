package com.example;

import java.util.UUID;


public record Report(UUID id, Long userId, Operation operation, String username){


}
