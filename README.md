statusword
==========

this is a library to get information from the response of command in smartcard (SW1 SW2).

how to use:

  StatusWord sw = new StatusWord();
  System.out.println(sw.getMeaningSW1SW2("6A83"));
  
