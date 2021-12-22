SUMMARY = "Tensor Interface Module for OpenVX"
DESCRIPTION = "TIM-VX is a software integration module provided by VeriSilicon \
to facilitate deployment of Neural-Networks on OpenVX enabled ML accelerators. It serves as \
the backend binding for runtime frameworks such as Android NN, Tensorflow-Lite, MLIR, TVM and more."
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://LICENSE;md5=ededf2503f5d147ae718276dfd28801f"

DEPENDS = "imx-gpu-viv nn-imx"

TIM_VX_SRC ?= "git://github.com/nxpmicro/tim-vx-imx.git;protocol=https"
SRCBRANCH = "lf-5.10.52_2.1.0"
SRCREV = "98b9759663a1eb6189cf86d93d8eb9d25925280d"
SRC_URI = "${TIM_VX_SRC};branch=${SRCBRANCH} \
           file://0001-Add-support-for-depthwise-conv2d-and-add-pad-to-pool.patch \
           file://0001-Keep-original-CXX_FLAGS.patch"

S = "${WORKDIR}/git"

inherit cmake

EXTRA_OECMAKE =  " \
    -DCONFIG=YOCTO \
    -DTIM_VX_ENABLE_TEST=off \
    -DTIM_VX_USE_EXTERNAL_OVXLIB=on \
    -DOVXLIB_INC=${PKG_CONFIG_SYSROOT_DIR}/usr/include/OVXLIB \
"

# Output library is unversioned
SOLIBS = ".so"
FILES_SOLIBSDEV = ""

COMPATIBLE_MACHINE          = "(^$)"
COMPATIBLE_MACHINE_imxgpu3d = "(mx8)"
COMPATIBLE_MACHINE_mx8mm    = "(^$)"

