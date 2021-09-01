import os
import tkinter as tk
from tkinter import filedialog as fd
from tkinter.messagebox import showinfo

from PIL import Image, ImageDraw, ImageFont, ImageTk

filename = ''

def set_center_geometry(win):
    win.update()

    screen_width = win.winfo_screenwidth()
    screen_height = win.winfo_screenheight()
    width = win.winfo_width()
    height = win.winfo_height()
    x = int((screen_width - width) / 2)
    y = int((screen_height - height) / 2)
    size = '%dx%d+%d+%d' % (width, height, x, y)
    win.geometry(size)

def select_file():
    filename = ''
    try:
        filetypes = (('image files', '*.jpg'), ('image files', '*.png'),
                     ('image files', '*.gif'), ('video files', '*.avi'),
                     ('video files', '*.mp4'), ('video files', '*.mpeg'),
                     ('all files', '*.*'))

        filename = fd.askopenfilename(
            title= 'Open a file',
            initialdir=os.curdir,
            filetypes=filetypes)

        if len(filename) > 0:
            showinfo(title='Selected File', message=filename)
    except Exception as e:
        raise e
    return filename

def show_image_1(args):
    global filename
    filename = select_file()
    if len(filename) > 0:
        try:
            img = ImageTk.PhotoImage(Image.open(filename))
            args.image = img
            args.config(image=img)
        except:
            pass
    else:
        showinfo(title='Warning', message='No File Selected')

def show_image_2(args):
    global filename
    if len(filename) > 0:
        try:
            img = ImageTk.PhotoImage(Image.open(filename))
            args.image = img
            args.config(image=img)
        except:
            pass
    else:
        showinfo(title='Warning', message='No File Selected')

def main():
    window = tk.Tk()
    window.title('Sample Demo')
    window.geometry('1200x800')
    window.resizable(True, True)
    set_center_geometry(window)

    # prepare default iamge to display
    alphabets = 'no image'
    img = Image.new("RGB", (250, 250), color="white")
    img_draw = ImageDraw.Draw(img)
    font = ImageFont.truetype("arial.ttf", 20)
    img_draw.text((90, 110), alphabets, fill=(255, 0, 0), font=font)
    tk_img = ImageTk.PhotoImage(img)

    # scrollbar

    # add frame1, frame2 to main window
    frame_1 = tk.Frame(window)
    frame_2 = tk.Frame(window)
    frame_1.grid(column=0, row=0, sticky='ns', padx=20, pady=20)
    frame_2.grid(column=1, row=0, sticky='ns', padx=20, pady=20)

    # add label, button to frame1
    label_txt_1 = tk.Label(frame_1, text='Image Select', font=('Arial', 20))
    label_txt_1.grid(column=0, row=0, sticky='nsw', pady=20)

    label_btn_1 = tk.Button(frame_1, text='Open', bg='#718ede', command=(lambda:show_image_1(label_img_1)))
    label_btn_1.grid(column=1, row=0, sticky='w', padx=20, pady=20)

    # add label to main window
    label_img_1 = tk.Label(window, fg='black', image=tk_img)
    label_img_1.grid(column=0, row=1, sticky='nswe', padx=20, pady=20)

    # add label, button to frame2
    label_txt_2 = tk.Label(frame_2, text='Copy Iamge', font=('Arial', 20))
    label_txt_2.grid(column=0, row=0, sticky='nsw', pady=20)

    label_btn_2 = tk.Button(frame_2, text='Copy', bg='#718ede', command=(lambda:show_image_2(label_img_2)))
    label_btn_2.grid(column=1, row=0, sticky='w', padx=20, pady=20)

    # add label to main window
    label_img_2 = tk.Label(window, fg='black', image=tk_img)
    label_img_2.grid(column=1, row=1, sticky='nswe', padx=20, pady=20)

    # set flexible position
    window.columnconfigure([0,1], weight=1)
    window.rowconfigure(0, weight=0)
    window.rowconfigure(1, weight=1)
    frame_1.columnconfigure(1, weight=1)
    frame_2.columnconfigure(1, weight=1)

    window.mainloop()

if __name__ == '__main__':
    main()
