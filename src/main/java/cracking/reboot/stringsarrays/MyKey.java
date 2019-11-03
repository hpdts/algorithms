package cracking.reboot.stringarrays;

import java.util.*;

class MyKey
{
  String key;
  MyKey(String key)
  {
    this.key = key;
  }
  
  @Override
  public int hashCode() 
  {
     return (int)key.charAt(0);
  }

  @Override
  public boolean equals(Object obj)
  {
    return key.equals((String)obj);
  }
}