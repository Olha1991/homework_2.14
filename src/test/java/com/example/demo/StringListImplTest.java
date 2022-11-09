package com.example.demo;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

public class StringListImplTest {
    private final StringList stringList = new StringListImpl();

    @AfterEach
    public void afterEach(){
        stringList.clear();
    }

    @Test
    public void addTest(){
        String[] elements = {"1", "2", "3", "4"};
        add(elements);
        for(int i = 0; i < elements.length; i++){
            assertThat(stringList.get(i)).isEqualTo(elements[i]);
            assertThat(stringList.contains(elements[i])).isTrue();
            assertThat(stringList.indexOf(elements[i])).isEqualTo(i);
            assertThat(stringList.lastIndexOf(elements[i])).isEqualTo(i);
        }
        assertThat(stringList.toArray()).hasSize(elements.length);
        assertThat(stringList.toArray()).containsExactly(elements);
    }

    @Test
    public void addByIndexTest() {
        String[] elements = {"1", "2", "3", "4"};
        add(elements);

        stringList.add(0, "6");
        assertThat(stringList.size()).isEqualTo(elements.length + 1);
        assertThat(stringList.get(0)).isEqualTo("6");



        stringList.add(3, "6");
        assertThat(stringList.size()).isEqualTo(elements.length + 2);
        assertThat(stringList.get(3)).isEqualTo("6");
        assertThat(stringList.lastIndexOf("6")).isEqualTo(3);
        assertThat(stringList.indexOf("6")).isEqualTo(0);

        stringList.add(5, "6");
        assertThat(stringList.size()).isEqualTo(elements.length + 3);
        assertThat(stringList.get(5)).isEqualTo("6");
        assertThat(stringList.lastIndexOf("6")).isEqualTo(5);
        assertThat(stringList.indexOf("6")).isEqualTo(0);


    }

    private void add(String[] elements){
        assertThat(stringList.isEmpty()).isTrue();
        Stream.of(elements).forEach(stringList :: add);
        assertThat(stringList.size()).isEqualTo(elements.length);

    }
}
