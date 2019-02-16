package com.jph.jphchat;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChatUserRepository extends CrudRepository<ChatUser, String> {

    //automatically stores all pristine Users and add them to all user as potential Chat partners
}
