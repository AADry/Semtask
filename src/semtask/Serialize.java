/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package semtask;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author Admin
 */
public final class Serialize {

    private final String path;
    private final File file;
    private Object object;

    public Serialize(final String path) {
        this.path = path;
        this.file = new File(path);
    }

    public void serialize(final Object object) {
        try (final FileOutputStream FileOutputStream = new FileOutputStream(path);
             final ObjectOutputStream ObjectOutputStream = new ObjectOutputStream(FileOutputStream)) {
            ObjectOutputStream.writeObject(object);
        } catch (final IOException io) {
            //...логи ошибок
        }
    }

    public Object deserialize() {
        try (final FileInputStream FileOutputStream = new FileInputStream(path);
             final ObjectInputStream ObjectInputStream = new ObjectInputStream(FileOutputStream)) {
            object = ObjectInputStream.readObject();
        } catch (final IOException | ClassNotFoundException ex) {
            //...логи ошибок
        }
        return object;
    }

    public boolean is() {
        return null != this.file && this.file.exists();
    }
}