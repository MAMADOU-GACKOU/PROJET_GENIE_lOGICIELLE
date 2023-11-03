/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package fr.ufrsciencestech.view;

import java.awt.Component;
import java.awt.Container;
/**
 *
 * @author AAlmountassir
 */
public class TestUtils {
    public static Component getChildNamed(Component parent, String name) {
         
         if (name.equals(parent.getName())) { return parent; }
   
         if (parent instanceof Container) {
            Component[] children = ((Container)parent).getComponents();
   
            for (int i = 0; i < children.length; ++i) {
               Component child = getChildNamed(children[i], name);
               if (child != null) { return child; }
            }
         }
         return null;
    }
    
}
