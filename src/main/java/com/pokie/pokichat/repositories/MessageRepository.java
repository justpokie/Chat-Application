package com.pokie.pokichat.repositories;

import com.pokie.pokichat.model.Message;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface MessageRepository extends JpaRepository<Message, Integer> {

    @Query("SELECT m FROM Message m WHERE m.channel.channel_id = :channelId ORDER BY m.dateCreated DESC")
    List<Message> getMessagesByChannel(@Param("channelId") Integer channelId);

}
