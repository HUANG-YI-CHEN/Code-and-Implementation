import os
import sys

import cairosvg
# import pyvips
from reportlab.graphics import renderPM
from svglib.svglib import svg2rlg


def svg2fmt(src_path, dst_path, fmt='png'):
    if os.path.exists(src_path) and os.path.exists(dst_path):
        fmt = fmt
        for file in os.listdir(src_path):
            drawing = svg2rlg(os.path.join(src_path, file))
            renderPM.drawToFile(drawing,
                                os.path.join(dst_path,
                                             file.replace('.svg', '.' + fmt)),
                                fmt=fmt.upper())


def svg2png(src_path, dst_path):
    if os.path.exists(src_path) and os.path.exists(dst_path):
        for file in os.listdir(src_path):
            cairosvg.svg2png(url=open(os.path.join(src_path, file), "rb"),
                             write_to=os.path.join(
                                 dst_path, file.replace('.svg', '.png')))


def rmfiles(src_path, fmt):
    if os.path.exists(src_path):
        for file in os.listdir(src_path):
            name, format = os.path.splitext(file)
            if format == '.' + fmt:
                filename = os.path.join(src_path, file)
                if os.path.exists(filename):
                    os.remove(filename)


def main():
    src_path = r''
    dst_path = r''
    fmt = 'png'

    # rmfiles(src_path=dst_path, fmt=fmt)
    svg2fmt(src_path=src_path, dst_path=dst_path, fmt=fmt)
    # svg2png(src_path=src_path, dst_path=dst_path)


if __name__ == '__main__':
    main()
