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
package dorkbox.notify;

import dorkbox.util.*;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.SoftReference;
import java.util.HashMap;
import java.util.Map;

/**
 * Popup notification messages, similar to the popular "Growl" notification system on macosx, that display in the corner of the monitor.
 * </p>
 * They can follow the mouse (if the screen is unspecified), and have a variety of features, such as "shaking" to draw attention,
 * animating upon movement (for collating w/ multiple in a single location), and automatically hiding after a set duration.
 * </p>
 * These notifications are for a single screen only, and cannot be anchored to an application.
 *
 * <pre>
 * {@code
 * Notify.create()
 *      .title("Title Text")
 *      .text("Hello World!")
 *      .useDarkStyle()
 *      .showWarning();
 * }
 * </pre>
 */
@SuppressWarnings({"WeakerAccess", "unused", "UnusedReturnValue"})
public final
class Notify {

  public static final String DIALOG_ALARM = "DialogAlarm.png";
  public static final String DIALOG_AMBULANCE = "DialogAmbulance.png";
  public static final String DIALOG_BANKCARDS = "DialogBankCards.png";
  public static final String DIALOG_BLUETOOTH = "DialogBluetooth.png";
  public static final String DIALOG_CALENDAR = "DialogCalendar.png";
  public static final String DIALOG_CDRIVE = "DialogCDrive.png";
  public static final String DIALOG_CHIP = "DialogChip.png";
  public static final String DIALOG_CLINIC = "DialogClinic.png";
  public static final String DIALOG_CONFIRM = "DialogConfirm.png";
  public static final String DIALOG_CONTACT = "DialogContact.png";
  public static final String DIALOG_CSV = "DialogCSV.png";
  public static final String DIALOG_DEFAULT = "DialogDefault.png";
  public static final String DIALOG_DOCTOR = "DialogDoctor.png";
  public static final String DIALOG_DOCTORSBAG = "DialogDoctorsBag.png";
  public static final String DIALOG_DOCUMENTS = "DialogDocuments.png";
  public static final String DIALOG_DOWNLOAD = "DialogDownload.png";
  public static final String DIALOG_ERROR = "DialogError.png";
  public static final String DIALOG_EXCEL = "DialogExcel.png";
  public static final String DIALOG_FACEBOOK = "DialogFacebook.png";
  public static final String DIALOG_FOLDER = "DialogFolder.png";
  public static final String DIALOG_FULLCHARGE = "DialogFullCharge.png";
  public static final String DIALOG_FUNDACCOUNTING = "DialogFundAccounting.png";
  public static final String DIALOG_GMAIL = "DialogGmail.png";
  public static final String DIALOG_GOOGLE = "DialogGoogle.png";
  public static final String DIALOG_HASH = "DialogHash.png";
  public static final String DIALOG_HDD = "DialogHDD.png";
  public static final String DIALOG_HEADSET = "DialogHeadset.png";
  public static final String DIALOG_HEALTHY = "DialogHealthy.png";
  public static final String DIALOG_HEARTHEALTH = "DialogHeartHealth.png";
  public static final String DIALOG_IMAGE = "DialogImage.png";
  public static final String DIALOG_INFO = "DialogInfo.png";
  public static final String DIALOG_INSTAGRAM = "DialogInstagram.png";
  public static final String DIALOG_LIGHTNING = "DialogLightning.png";
  public static final String DIALOG_LINKEDIN = "DialogLinkedIn.png";
  public static final String DIALOG_LINUX = "DialogLinux.png";
  public static final String DIALOG_MAPS = "DialogMaps.png";
  public static final String DIALOG_MESSAGE = "DialogMessage.png";
  public static final String DIALOG_MESSENGER = "DialogMessenger.png";
  public static final String DIALOG_MOUSE = "DialogMouse.png";
  public static final String DIALOG_MUSIC = "DialogMusic.png";
  public static final String DIALOG_NEXT = "DialogNext.png";
  public static final String DIALOG_NFC = "DialogNFC.png";
  public static final String DIALOG_NOTES = "DialogNotes.png";
  public static final String DIALOG_OK = "DialogOk.png";
  public static final String DIALOG_PDF = "DialogPDF.png";
  public static final String DIALOG_PIE_CHART = "DialogPieChart.png";
  public static final String DIALOG_PILL = "DialogPill.png";
  public static final String DIALOG_PLUGIN = "DialogPlugin.png";
  public static final String DIALOG_QUERY = "DialogQuery.png";
  public static final String DIALOG_QUESTION = "DialogQuestion.png";
  public static final String DIALOG_REST_API = "DialogRestAPI.png";
  public static final String DIALOG_ROD_OF_ASCLEPIUS = "DialogRodOfAsclepius.png";
  public static final String DIALOG_RSS = "DialogRss.png";
  public static final String DIALOG_SECURE = "DialogSecure.png";
  public static final String DIALOG_SHUTDOWN = "DialogShutdown.png";
  public static final String DIALOG_SJ = "DialogSJ.png";
  public static final String DIALOG_SKYPE = "DialogSkype.png";
  public static final String DIALOG_SOFTWARE_INSTALLER = "DialogSoftwareInstaller.png";
  public static final String DIALOG_STETHOSCOPE = "DialogStethoscope.png";
  public static final String DIALOG_SYNC = "DialogSync.png";
  public static final String DIALOG_SYRINGE = "DialogSyringe.png";
  public static final String DIALOG_TOGGLE_OFF = "DialogToggleOff.png";
  public static final String DIALOG_TOGGLE_ON = "DialogToggleOn.png";
  public static final String DIALOG_TOOTH = "DialogTooth.png";
  public static final String DIALOG_TRANSLATE = "DialogTranslate.png";
  public static final String DIALOG_TREATMENT = "DialogTreatment.png";
  public static final String DIALOG_TWITTER = "DialogTwitter.png";
  public static final String DIALOG_UPDATE = "DialogUpdate.png";
  public static final String DIALOG_VISA = "DialogVisa.png";
  public static final String DIALOG_WARNING = "DialogWarning.png";
  public static final String DIALOG_WEATHER = "DialogWeather.png";
  public static final String DIALOG_WHATSAPP = "DialogWhatsApp.png";
  public static final String DIALOG_WIFI = "DialogWiFi.png";
  public static final String DIALOG_WINDOWS = "DialogWindows.png";
  public static final String DIALOG_WINRAR = "DialogWinRAR.png";
  public static final String DIALOG_WORD = "DialogWord.png";
  public static final String DIALOG_YAHOO = "DialogYahoo.png";
  public static final String DIALOG_YOUTUBE = "DialogYouTube.png";

  /**
   * This is the title font used by a notification.
   */
  @Property
  public static String TITLE_TEXT_FONT = "Source Code Pro BOLD 16";

  /**
   * This is the main text font used by a notification.
   */
  @Property
  public static String MAIN_TEXT_FONT = "Source Code Pro BOLD 12";

  /**
   * How long we want it to take for the popups to relocate when one is closed
   */
  @Property
  public static float MOVE_DURATION = 1.0F;

  /**
   * Location of the dialog image resources. By default they must be in the 'resources' directory relative to the application
   */
  @Property
  public static String IMAGE_PATH = "resources";

  private static Map<String, SoftReference<ImageIcon>> imageCache = new HashMap<String, SoftReference<ImageIcon>>(4);

  /**
   * Gets the version number.
   */
  public static String getVersion() {
    return "3.8";
  }

  /**
   * Builder pattern to create the notification.
   */
  public static Notify create() {
    return new Notify();
  }

  /**
   * Gets the size of the image to be used in the notification, which is a 48x48 pixel image.
   */
  public static int getImageSize() {
    return 48;
  }

  /**
   * Permits one to override the default images for the dialogs. This is NOT thread safe, and must be performed BEFORE showing a
   * notification.
   * <p>
   * The image names are as follows:
   * <p>
   * 'Notify.DIALOG_CONFIRM' 'Notify.DIALOG_INFORMATION' 'Notify.DIALOG_WARNING' 'Notify.DIALOG_ERROR'
   *
   * @param imageName the name of the image, either your own if you want want it cached, or one of the above.
   * @param image     the BufferedImage that you want to cache.
   */
  public static void overrideDefaultImage(String imageName, BufferedImage image) {
    if (imageCache.containsKey(imageName)) {
      throw new RuntimeException("No se puede establecer una imagen que ya se ha configurado. Esta acción debe hacerse lo antes posible.");
    }

    Image imageImmediate = ImageUtil.getImageImmediate(image);

    // we only use 48x48 pixel images. Resize as necessary
    int width = imageImmediate.getWidth(null);
    int height = imageImmediate.getHeight(null);

    BufferedImage bufferedImage;

    // resize the image, keep aspect ratio
    if (width > height) {
      bufferedImage = ImageUtil.resizeImage(image, getImageSize(), -1);
    } else {
      bufferedImage = ImageUtil.resizeImage(image, -1, getImageSize());
    }

    imageCache.put(imageName, new SoftReference<ImageIcon>(new ImageIcon(bufferedImage)));
  }

  private static ImageIcon getImage(String imageName) {
    ImageIcon image = null;
    InputStream resourceAsStream = null;

    try {
      SoftReference<ImageIcon> reference = imageCache.get(imageName);

      if (reference != null) {
        image = reference.get();
      }

      if (image == null) {
        String name = IMAGE_PATH + File.separatorChar + imageName;

        resourceAsStream = LocationResolver.getResourceAsStream(name);

        image = new ImageIcon(ImageUtil.getImageImmediate(ImageIO.read(resourceAsStream)));
        imageCache.put(imageName, new SoftReference<ImageIcon>(image));
      }
    } catch (IOException e) {
      e.printStackTrace();
    } finally {
      if (resourceAsStream != null) {
        try {
          resourceAsStream.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }

    return image;
  }


  String title;
  String text;

  Theme theme;

  Pos position = Pos.BOTTOM_RIGHT;
  int hideAfterDurationInMillis = 0;

  boolean hideCloseButton;
  boolean isDark = false;
  int screenNumber = Short.MIN_VALUE;
  private ImageIcon icon;

  ActionHandler<Notify> onGeneralAreaClickAction;
  private INotify notifyPopup;

  //    private String name;
  private int shakeDurationInMillis = 0;
  private int shakeAmplitude = 0;
  private JFrame appWindow;

  private Notify() {
  }

  /**
   * Especifica el texto principal
   */
  public Notify text(String text) {
    this.text = text;
    return this;
  }

  /**
   * Especifica el título
   */
  public Notify title(String title) {
    this.title = title;
    return this;
  }

  /**
   * Specifies the image
   */
  public Notify image(Image image) {
    // we only use 48x48 pixel images. Resize as necessary
    int width = image.getWidth(null);
    int height = image.getHeight(null);

    BufferedImage bufferedImage = ImageUtil.getBufferedImage(image);

    // resize the image, keep aspect ratio
    if (width > height) {
      bufferedImage = ImageUtil.resizeImage(bufferedImage, 48, -1);
    } else {
      bufferedImage = ImageUtil.resizeImage(bufferedImage, -1, 48);
    }

    // we have to now clamp to a max dimension of 48
    bufferedImage = ImageUtil.clampMaxImageSize(bufferedImage, 48);

    // now we want to center the image
    bufferedImage = ImageUtil.getSquareBufferedImage(bufferedImage);

    this.icon = new ImageIcon(bufferedImage);
    return this;
  }

  /**
   * Especifica la posición de la notificación en la pantalla, por defecto es {@link Pos # BOTTOM_RIGHT abajo a la derecha}.
   */
  public Notify position(Pos position) {
    this.position = position;
    return this;
  }

  /**
   * Especifica la duración que debe mostrar la notificación, después de lo cual se ocultará. 0 significa mostrar para siempre. Por defecto es
   * se mostrará para siempre
   */
  public Notify hideAfter(int durationInMillis) {
    if (durationInMillis < 0) {
      durationInMillis = 0;
    }
    this.hideAfterDurationInMillis = durationInMillis;
    return this;
  }

  /**
   * Especifica qué hacer cuando el usuario hace clic en la notificación (además de la ocultación de la notificación, que ocurre cada vez que
   * se hace clic en la notificación). Esto no se aplica al hacer clic en el botón "cerrar"
   */
  public Notify onAction(ActionHandler<Notify> onAction) {
    this.onGeneralAreaClickAction = onAction;
    return this;
  }

  /**
   * Especifica que la notificación debe usar el estilo oscuro incorporado, en lugar del estilo de notificación gris claro predeterminado.
   */
  public Notify darkStyle() {
    isDark = true;
    return this;
  }

  /**
   * Especifica cuál debería ser el tema, si no es el predeterminado. Esto siempre tendrá prioridad sobre los valores predeterminados.
   */
  public Notify text(Theme theme) {
    this.theme = theme;
    return this;
  }

  /**
   * Especifique que el botón de cerrar en la esquina superior derecha de la notificación no se debe mostrar.
   */
  public Notify hideCloseButton() {
    this.hideCloseButton = true;
    return this;
  }

  /**
   * Muestra la notificación con la imagen que se envia por marametro incorporada.
   */
  public void showNotify(String name_icon) {
//        name = DIALOG_ERROR;
    icon = getImage(name_icon);
    show();
  }

  /**
   * Shows the notification. If the Notification is assigned to a screen, but shown inside a Swing/etc parent, the screen number will be
   * ignored.
   */
  public void show() {
    // must be done in the swing EDT
    //noinspection Convert2Lambda
    SwingUtil.invokeAndWaitQuietly(new Runnable() {
      @Override
      public void run() {
        final Notify notify = Notify.this;
        final ImageIcon image = notify.icon;

        Theme theme;
        if (notify.theme != null) {
          // use custom theme.
          theme = notify.theme;
        } else {
          theme = new Theme(Notify.TITLE_TEXT_FONT, Notify.MAIN_TEXT_FONT, notify.isDark);
        }

        if (appWindow == null) {
          notifyPopup = new AsDesktop(notify, image, theme);
        } else {
          notifyPopup = new AsApplication(notify, image, appWindow, theme);
        }

        notifyPopup.setVisible(true);

        if (shakeDurationInMillis > 0) {
          notifyPopup.shake(notify.shakeDurationInMillis, notify.shakeAmplitude);
        }
      }
    });

    // don't need to hang onto these.
    icon = null;
  }

  /**
   * "shakes" the notification, to bring user attention to it.
   *
   * @param durationInMillis now long it will shake
   * @param amplitude        a measure of how much it needs to shake. 4 is a small amount of shaking, 10 is a lot.
   */
  public Notify shake(final int durationInMillis, final int amplitude) {
    this.shakeDurationInMillis = durationInMillis;
    this.shakeAmplitude = amplitude;

    if (notifyPopup != null) {
      // debe hacerse en el swing EDT
      //noinspection Convert2Lambda
      SwingUtil.invokeLater(new Runnable() {
        @Override
        public void run() {
          notifyPopup.shake(durationInMillis, amplitude);
        }
      });
    }

    return this;
  }

  /**
   * Closes the notification. Particularly useful if it's an "infinite" duration notification.
   */
  public void close() {
    if (notifyPopup == null) {
      throw new NullPointerException("NotifyPopup");
    }

    // must be done in the swing EDT
    //noinspection Convert2Lambda
    SwingUtil.invokeLater(new Runnable() {
      @Override
      public void run() {
        notifyPopup.close();
      }
    });
  }

  /**
   * Especifica en qué pantalla mostrar. Si <0, se mostrará en la pantalla 0. Si> máx-pantallas, se mostrará en la última pantalla.
   */
  public Notify setScreen(final int screenNumber) {
    this.screenNumber = screenNumber;
    return this;
  }

  /**
   * Attaches this notification to a specific JFrame, instead of having a global notification
   */
  public Notify attach(final JFrame frame) {
    this.appWindow = frame;
    return this;
  }


  // called when this notification is closed.
  void onClose() {
    notifyPopup = null;
  }
}

