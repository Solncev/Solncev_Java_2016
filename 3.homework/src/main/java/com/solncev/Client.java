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
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        UserRepository userRepository = new UserRepositoryImpl();
        MessageRepository messageRepository = new MessageRepositoyImpl();
        RequestRepository requestRepository = new RequestRepositoryImpl();
        CommunityRepository communityRepository = new CommunityRepositoryImpl();
        NewsRepository newsRepository = new NewsRepositoryImpl();

        String in = "";
        System.out.println("Hello, enter \"help\" to view a list of commands and enter \"exit\" if you want to close the program");
        while (!in.toLowerCase().equals("exit")) {
            in = scanner.nextLine();
            switch (in.toLowerCase()) {
                case "help":
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

                case "add user":
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
                    break;
                case "add message":
                    Message message = new Message();
                    System.out.println("enter text");
                    message.setText(scanner.nextLine());
                    System.out.println("enter sender id");
                    message.setSender_id(scanner.nextLong());
                    System.out.println("enter recipient id");
                    message.setRecipient_id(scanner.nextLong());
                    System.out.println("enter date in such form" +
                            " 2016-02-19 03:59:13");
                    scanner.nextLine();
                    message.setCreated_at(scanner.nextLine());
                    System.out.println("enter status");
                    message.setStatus(scanner.nextLine());
                    messageRepository.add(message);
                    System.out.println("message successfully added");
                    break;
                case "add request":
                    Request request = new Request();
                    System.out.println("enter needy id");
                    request.setNeedy_id(scanner.nextLong());
                    System.out.println("enter volunteer id");
                    request.setVolunteer_id(scanner.nextLong());
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
                    request.setCreated_at(scanner.nextLine());
                    System.out.println("enter service type");
                    request.setService_type(scanner.nextLine());
                    System.out.println("enter status");
                    request.setStatus(scanner.nextLine());
                    requestRepository.add(request);
                    System.out.println("request successfully added");
                    break;
                case "change community":
                    Community community = new Community();
                    System.out.println("enter community id");
                    Long id = scanner.nextLong();
                    System.out.println("enter new name");
                    scanner.nextLine();
                    community.setName(scanner.nextLine());
                    System.out.println("enter new description");
                    community.setDescription(scanner.nextLine());
                    System.out.println("enter founder id");
                    community.setFounder_id(scanner.nextLong());
                    scanner.nextLine();
                    System.out.println("enter date in such form" +
                            " 2016-02-19");
                    community.setCreated_at(scanner.nextLine());
                    communityRepository.update(id, community);
                    System.out.println("community successfully updated");
                    break;
                case "change news":
                    News news = new News();
                    System.out.println("enter news id");
                    Long news_id = scanner.nextLong();
                    scanner.nextLine();
                    System.out.println("enter new text");
                    news.setText(scanner.nextLine());
                    System.out.println("enter new community id");
                    news.setCommunity_id(scanner.nextLong());
                    System.out.println("enter new author id");
                    news.setAuthor_id(scanner.nextLong());
                    scanner.nextLine();
                    System.out.println("enter date in such form" +
                            " 2016-02-19 03:59:13");
                    news.setCreated_at(scanner.nextLine());
                    newsRepository.update(news_id, news);
                    System.out.println("news successfully updated");
                    break;
                case "get the number of news written by defined user":
                    System.out.println("enter user id");
                    int c = newsRepository.getCountByAuthorId(scanner.nextLong());
                    scanner.nextLine();
                    System.out.println(c);
                    break;
                case "get user received the highest number of messages for the season":
                    System.out.println("enter season. winter, spring, summer or autumn");
                    List<User> users = userRepository.getReceivedHighestNumberOfMessage(scanner.nextLine());
                    for (User u :
                            users) {
                        System.out.println(u.toString());
                    }
                    break;
                case "get user responded for the highest number of request at the address":
                    System.out.println("enter address");
                    List<User> users1 = userRepository.getRespondedHighestNumberOfRequest(scanner.nextLine());
                    for (User u :
                            users1) {
                        System.out.println(u.toString());
                    }
                    break;
                default:
                    System.out.println("incorrect command, enter \"help\" to view list of commands");
            }
        }
    }
}
