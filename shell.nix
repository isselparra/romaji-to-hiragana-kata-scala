 let
   nixpkgs = fetchTarball "https://github.com/NixOS/nixpkgs/tarball/nixos-22.11";
   pkgs = import nixpkgs { config = {}; overlays = []; };
 in

pkgs.mkShell {
  buildInputs = [
    pkgs.jdk17_headless
    pkgs.sbt
  ];

  LC_ALL = "C.UTF-8";
}

