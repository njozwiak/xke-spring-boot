package com.xebia.domain;

import com.google.common.collect.Lists;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="clientList")
public class ClientList {

  @XmlElement(required = true)
  public List<Client> clients = Lists.newArrayList();

  public ClientList() {
  }

  public ClientList(List<Client> clients) {
    this.clients = clients;
  }
}
