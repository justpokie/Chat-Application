package com.pokie.pokichat.repositories;

import com.pokie.pokichat.model.Channel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChannelRepository extends JpaRepository<Channel, Integer> {
}
