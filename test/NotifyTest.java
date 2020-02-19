/*
 * Copyright 2015 dorkbox, llc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

import dorkbox.notify.Notify;
import dorkbox.notify.Pos;
import dorkbox.util.ActionHandler;
import dorkbox.util.ImageUtil;
import dorkbox.util.LocationResolver;
import dorkbox.util.ScreenUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public
class NotifyTest {

  public static void main(String[] args) {
    Notify notify;


    JFrame frame = new JFrame("Prueba");

    JPanel panel = new JPanel();
    panel.setLayout(new FlowLayout());

    JLabel label = new JLabel("Esta es una etiqueta!");

    JButton button = new JButton();
    button.setText("Presioname");

    panel.add(label);
    panel.add(button);

    frame.add(panel);
    frame.setSize(900, 600);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.setVisible(true);

    ScreenUtil.showOnSameScreenAsMouse_Center(frame);


    int count = 2;

    for (int i = 0; i < count; i++) {
      final int finalI = i;
      notify = Notify.create()
              .title("Notificar título " + i)
              .text("Esta es una notificación " + i + " mensaje emergente Este es un mensaje emergente de notificación Este es un " +
                      "mensaje emergente de notificación")
              .hideAfter(13000)
              .position(Pos.BOTTOM_RIGHT)
              // .position(Pos.CENTER)
              // .setScreen(0)
              .darkStyle()
              // .shake(1300, 4)
              .shake(1300, 10)
              .attach(frame)
              .hideCloseButton()
              .onAction(new ActionHandler<Notify>() {
                @Override
                public void handle(final Notify arg0) {
                  System.err.println("Notificación " + finalI + " hizo clic en!");
                }
              });
      notify.showNotify(Notify.DIALOG_ALARM);

      // try {
      //     Thread.sleep(1000);
      // } catch (InterruptedException e) {
      //     e.printStackTrace();
      // }
    }

    for (int i = 0; i < count; i++) {
      final int finalI = i;
      notify = Notify.create()
              .title("Notificar título " + i)
              .text("Esta es una notificación " + i + " mensaje emergente Este es un mensaje emergente de notificación Este es un " +
                      "mensaje emergente de notificación")
              .hideAfter(13000)
              .position(Pos.TOP_LEFT)
              // .position(Pos.CENTER)
              // .setScreen(0)
              //      .darkStyle()
              // .shake(1300, 4)
              // .shake(1300, 10)
              .attach(frame)
              // .hideCloseButton()
              .onAction(new ActionHandler<Notify>() {
                @Override
                public void handle(final Notify arg0) {
                  System.err.println("Notificación " + finalI + " hizo clic en!");
                }
              });
      notify.showNotify(Notify.DIALOG_CONTACT);

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }


    for (int i = 0; i < count; i++) {
      final int finalI = i;
      notify = Notify.create()
              .title("Notificar título " + i)
              .text("Esta es una notificación " + i + " mensaje emergente Este es un mensaje emergente de notificación Este es un " +
                      "mensaje emergente de notificación")
              .hideAfter(3000)
              .position(Pos.TOP_RIGHT)
//                       .setScreen(0)
              .darkStyle()
              // .shake(1300, 4)
              .shake(1300, 10)
              .hideCloseButton()
              .onAction(new ActionHandler<Notify>() {
                @Override
                public void handle(final Notify arg0) {
                  System.err.println("Notificación " + finalI + " hizo clic en!");
                }
              });
      notify.show();

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }

    InputStream resourceAsStream = LocationResolver.getResourceAsStream("notify-dark.png");
    Image image = null;
    try {
      image = ImageUtil.getImageImmediate(ImageIO.read(resourceAsStream));
      // image = image.getScaledInstance(144, 104, Image.SCALE_SMOOTH);
      // image = image.getScaledInstance(104, 144, Image.SCALE_SMOOTH);
      image = image.getScaledInstance(144, 144, Image.SCALE_SMOOTH);
    } catch (IOException e) {
      e.printStackTrace();
    }


    for (int i = 0; i < count; i++) {
      final int finalI = i;
      notify = Notify.create()
              .title("Notificar título " + i)
              .text("Esta es una notificación " + i + " mensaje emergente Este es un mensaje emergente de notificación Este es un " +
                      "mensaje emergente de notificación")
              // .hideAfter(13000)
              .position(Pos.BOTTOM_LEFT)
//                       .setScreen(0)
//                            .darkStyle()
              // .shake(1300, 4)
              // .shake(1300, 10)
              // .hideCloseButton()
              .onAction(new ActionHandler<Notify>() {
                @Override
                public void handle(final Notify arg0) {
                  System.err.println("Notificación " + finalI + " hizo clic en!");
                }
              });

      if (i == 0) {
        notify.image(image);
        notify.show();
      } else {
        notify.showNotify(Notify.DIALOG_CONFIRM);
      }

      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
    }
  }
}
