package dataStore;

import except.ExtenException;
import java.awt.Component;
import java.awt.Shape;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.List;
import view.Figure;


public abstract class ADS {
        private String[] supExts;
        private File file;
        private String fExt;


        public abstract void save(Component comp) throws IOException;
        public abstract Component load() throws IOException;

        public void setSuppExts(String[] supportedExts) {
                this.supExts = supportedExts;
        }

        public String[] getSupExts() {
            return supExts;
        }

        public boolean supports(String ext){
                boolean res = false;

                for(String supportedExt : this.getSupExts())
                {
                    if(supportedExt.equals(ext))
                    {       res = true;
                            break;
                    }
                }
                return res;
        }

        public ADS checkType(String ext) throws ExtenException {

                ADS res = null;
                if (this.supports(ext)){
                        res = this;
                }
                else throw new ExtenException();

                return res;

        };

    public File getFile() {
        return file;
    }

    public String getfExt() {
        return fExt;
    }

    void setFile(File file) {
        this.file=file;
        this.fExt=file.getName().substring(file.getName().lastIndexOf('.')+1).toLowerCase();
    }
      

}


