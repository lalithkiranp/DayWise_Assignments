package com.example.library;

import org.springframework.stereotype.Component;

@Component
public class Member {
    public void registerMember() {
        System.out.println("New member registered.");
    }

    public void viewMembers() {
        System.out.println("Listing all members...");
    }
}
