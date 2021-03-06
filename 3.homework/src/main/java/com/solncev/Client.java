package com.solncev;

import com.solncev.entities.*;
import com.solncev.repositories.*;
import com.solncev.repositoriesImpl.*;

import java.util.List;
import java.util.Scanner;

/**
 * Created by Марат on 23.11.2016.
 */
public class Client {
    private static Scanner scanner = new Scanner(System.in);
    private static UserRepository userRepository = new UserRepositoryImpl();
    private static MessageRepository messageRepository = new MessageRepositoyImpl();
    private static RequestRepository requestRepository = new RequestRepositoryImpl();
    private static CommunityRepository communityRepository = new CommunityRepositoryImpl();
    private static NewsRepository newsRepository = new NewsRepositoryImpl();

    private static void addUser() {
        User user = new User();
        System.out.println("enter name");
        user.setName(scanner.nextLine());
        System.out.println("enter surname");
        user.setSurname(scanner.nextLine());
        System.out.println("enter email");
        user.setEmail(scanner.nextLine());
        System.out.println("enter password");
        user.setPassword(scanner.nextLine());
        System.out.println("enter role");
        user.setRole(scanner.nextLine());
        System.out.println("enter status");
        user.setStatus(scanner.nextLine());
        userRepository.add(user);
        System.out.println("user successfully added");
    }

    private static void addMessage() {
        Message message = new Message();
        System.out.println("enter text");
        message.setText(scanner.nextLine());
        System.out.println("enter sender id");
        message.setSenderId(scanner.nextLong());
        System.out.println("enter recipient id");
        message.setRecipientId(scanner.nextLong());
        System.out.println("enter date in such form" +
                " 2016-02-19 03:59:13");
        scanner.nextLine();
        message.setCreated_at(scanner.nextLine());
        System.out.println("enter status");
        message.setStatus(scanner.nextLine());
        messageRepository.add(message);
        System.out.println("message successfully added");
    }

    private static void addRequest() {
        Request request = new Request();
        System.out.println("enter needy id");
        request.setNeedyId(scanner.nextLong());
        System.out.println("enter volunteer id");
        request.setVolunteerId(scanner.nextLong());
        System.out.println("enter address");
        scanner.nextLine();
        request.setAddress(scanner.nextLine());
        System.out.println("enter latitude");
        request.setLatitude(scanner.nextDouble());
        System.out.println("enter longitude");
        request.setLongitude(scanner.nextDouble());
        System.out.println("enter date in such form" +
                " 2016-02-19 03:59:13");
        scanner.nextLine();
        request.setCreatedAt(scanner.nextLine());
        System.out.println("enter service type");
        request.setServiceType(scanner.nextLine());
        System.out.println("enter status");
        request.setStatus(scanner.nextLine());
        requestRepository.add(request);
        System.out.println("request successfully added");
    }

    private static void changeCommunity() {
        Community community = new Community();
        System.out.println("enter community id");
        Long id = scanner.nextLong();
        System.out.println("enter new name");
        scanner.nextLine();
        community.setName(scanner.nextLine());
        System.out.println("enter new description");
        community.setDescription(scanner.nextLine());
        System.out.println("enter founder id");
        community.setFounderId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("enter date in such form" +
                " 2016-02-19");
        community.setCreatedAt(scanner.nextLine());
        communityRepository.update(id, community);
        System.out.println("community successfully updated");
    }

    private static void changeNews() {
        News news = new News();
        System.out.println("enter news id");
        Long news_id = scanner.nextLong();
        scanner.nextLine();
        System.out.println("enter new text");
        news.setText(scanner.nextLine());
        System.out.println("enter new community id");
        news.setCommunityId(scanner.nextLong());
        System.out.println("enter new author id");
        news.setAuthorId(scanner.nextLong());
        scanner.nextLine();
        System.out.println("enter date in such form" +
                " 2016-02-19 03:59:13");
        news.setCreatedAt(scanner.nextLine());
        newsRepository.update(news_id, news);
        System.out.println("news successfully updated");
    }

    private static void getHelp() {
        System.out.println("if you want add new user, enter \"add user\"");
        System.out.println("if you want add new message, enter \"add message\"");
        System.out.println("if you want add new request, enter \"add request\"");
        System.out.println("if you want change community, enter \"change community\"");
        System.out.println("if you want change news, enter \"change news\"");
        System.out.println("if you want to get the number of news written by defined user, enter" +
                " \"get the number of news written by defined user\"");
        System.out.println("if you want to get user received the highest number of messages for the season, enter " +
                "\"get user received the highest number of messages for the season\"");
        System.out.println("if you want to get user responded for the highest number of request at the address, enter " +
                "\"get user responded for the highest number of request at the address\"");
    }

    private static void getCountByAuthorId() {
        System.out.println("enter user id");
        int c = newsRepository.getCountByAuthorId(scanner.nextLong());
        scanner.nextLine();
        System.out.println(c);
    }

    private static void getReceivedHighestNumberOfMessage() {
        System.out.println("enter season. winter, spring, summer or autumn");
        List<User> users = userRepository.getReceivedHighestNumberOfMessage(scanner.nextLine());
        for (User u :
                users) {
            System.out.println(u.toString());
        }
    }

    private static void getRespondedHighestNumberOfRequest() {
        System.out.println("enter address");
        List<User> users1 = userRepository.getRespondedHighestNumberOfRequest(scanner.nextLine());
        for (User u :
                users1) {
            System.out.println(u.toString());
        }
    }

    public static void main(String[] args) {
        String in = "";
        System.out.println("Hello, enter \"help\" to view a list of commands and enter \"exit\" if you want to close the program");
        while (!in.toLowerCase().equals("exit")) {
            in = scanner.nextLine();
            switch (in.toLowerCase()) {
                case "help":
                    getHelp();
                    break;
                case "add user":
                    addUser();
                    break;
                case "add message":
                    addMessage();
                    break;
                case "add request":
                    addRequest();
                    break;
                case "change community":
                    changeCommunity();
                    break;
                case "change news":
                    changeNews();
                    break;
                case "get the number of news written by defined user":
                    getCountByAuthorId();
                    break;
                case "get user received the highest number of messages for the season":
                    getReceivedHighestNumberOfMessage();
                    break;
                case "get user responded for the highest number of request at the address":
                    getRespondedHighestNumberOfRequest();
                    break;
                default:
                    System.out.println("incorrect command, enter \"help\" to view list of commands");
            }
        }
    }
}
