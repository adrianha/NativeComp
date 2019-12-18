//
//  RCTWrapperReactRootViewController.h
//  NativeComp
//
//  Created by adrian.hartanto on 16/12/19.
//  Copyright © 2019 Facebook. All rights reserved.
//

#import <UIKit/UIKit.h>

@class RCTBridge;

NS_ASSUME_NONNULL_BEGIN

@interface RCTWrapperReactRootViewController : UIViewController

- (instancetype)initWithBridge:(RCTBridge *)bridge;

@end

NS_ASSUME_NONNULL_END
