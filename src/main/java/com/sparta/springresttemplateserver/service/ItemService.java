package com.sparta.springresttemplateserver.service;

import com.sparta.springresttemplateserver.dto.ItemResponseDto;
import com.sparta.springresttemplateserver.dto.UserRequestDto;
import com.sparta.springresttemplateserver.entity.Item;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ItemService {

  private final List<Item> itemList = Arrays.asList(
          // Java에서 '_'은 가독성을 위해 사용하는 문법으로 컴파일러는 이를 숫자로 처리한다
          new Item("Mac", 3_888_000),
          new Item("iPad", 1_230_000),
          new Item("iPhone", 1_550_000),
          new Item("Watch", 450_000),
          new Item("AirPods", 350_000)
  );

  public Item getCallObject(String query) {
    for (Item item : itemList) {
      if(item.getTitle().equals(query)) {
        return item;
      }
    }
    return null;
  }

  public ItemResponseDto getCallList() {
    ItemResponseDto responseDto = new ItemResponseDto();
    for (Item item : itemList) {
      responseDto.setItems(item);
    }
    return responseDto;
  }


  public Item postCall(String query, UserRequestDto userRequestDto) {
    System.out.println("userRequestDto.getUsername() = " + userRequestDto.getUsername());
    System.out.println("userRequestDto.getPassword() = " + userRequestDto.getPassword());

    return getCallObject(query);
  }


  public ItemResponseDto exchangeCall(String token, UserRequestDto requestDto) {
    System.out.println("token = " + token);
    System.out.println("requestDto.getUsername() = " + requestDto.getUsername());
    System.out.println("requestDto.getPassword() = " + requestDto.getPassword());

    return getCallList();
  }
}